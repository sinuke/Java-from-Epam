package com.sinapps.task12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Date;

public class Airlines {
    private final Airline[] airlines;
    private final String[] TYPES = {
            "Туполев Ту-134",
            "Туполев Ту-154",
            "Туполев Ту-204",
            "Сухой Суперджет-100",
            "Ильюшин ИЛ-62",
            "Ильюшин ИЛ-86",
            "Ильюшин ИЛ-96",
            "ИЛ-96-300",
            "ИЛ-96М",
            "Аэробус Airbus A310",
            "Аэробус Airbus A320",
            "Аэробус Airbus A330",
            "Boeing-737",
            "Boeing-747",
            "Boeing-767",
            "Boeing-777"
    };
    private final String[] DESTINATIONS = {
            "Гонконг",
            "Бангкок",
            "Макао",
            "Сингапур",
            "Лондон",
            "Париж",
            "Дубай",
            "Дели",
            "Стамбул",
            "Куала-Лумпур"
    };
    private final Random random = new Random();
    private final SimpleDateFormat departureFormat = new SimpleDateFormat("HH:mm");

    public Airlines(int count) {
        airlines = generateRandomAirlinesList(count);
    }

    private Airline[] generateRandomAirlinesList(int count) {
        Airline[] result = new Airline[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Airline(generateRandomDestination(), generateRandomNumber(), generateRandomType(),
                    generateRandomDeparture(), generateRandomDays());
        }
        return result;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    private String generateRandomDestination() {
        return DESTINATIONS[random.nextInt(DESTINATIONS.length)];
    }

   private String generateRandomNumber() {
       String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       return SYMBOLS.charAt(random.nextInt(SYMBOLS.length())) + String.valueOf(SYMBOLS.charAt(random.nextInt(SYMBOLS.length()))) +
                String.format("%04d", random.nextInt(10000));
   }

   private String generateRandomType() {
        return TYPES[random.nextInt(TYPES.length)];
   }

   private Date generateRandomDeparture() {
       return new Date(random.nextLong());
   }

   private WeekDays[] generateRandomDays() {
        int count = random.nextInt(7) + 1;
        WeekDays[] result = new WeekDays[count];
        for (int i = 0; i < count; i++) {
            boolean isUsing = true;
            WeekDays randomDay = WeekDays.values()[random.nextInt(WeekDays.values().length)];
            while (isUsing) {
                isUsing = false;
                randomDay = WeekDays.values()[random.nextInt(WeekDays.values().length)];
                for (int j = 0; j < i; j++) {
                    if (result[j] == randomDay) {
                        isUsing = true;
                        break;
                    }
                }
            }

            result[i] = randomDay;
        }

        return result;
   }

   public Airline[] filterByDestination(String destination) {
        int count = 0;
        for (Airline airline : getAirlines()) {
            if (airline.getDestination().equals(destination)) {
                count++;
            }
        }

        Airline[] result = new Airline[count];
        int index = -1;
       for (Airline airline : getAirlines()) {
           if (airline.getDestination().equals(destination)) {
               index++;
               result[index] = airline;
           }
       }

       return result;
   }

   public Airline[] filterByDay(WeekDays day) {
        int count = 0;
        for (Airline airline : getAirlines()) {
            if (airline.containsDay(day)) {
                count++;
            }
        }

        Airline[] result = new Airline[count];
        int index = -1;
       for (Airline airline : getAirlines()) {
           if (airline.containsDay(day)) {
               index++;
               result[index] = airline;
           }
       }
        return result;
   }

   public Airline[] filterByDayAndTime(WeekDays day, String time) {
       try {
           int count = 0;
           Date needTime = departureFormat.parse(time);
           Calendar departure = Calendar.getInstance();
           Calendar neededTime = Calendar.getInstance();
           neededTime.setTime(needTime);

           int h2 = neededTime.get(Calendar.HOUR_OF_DAY);
           int m2 = neededTime.get(Calendar.MINUTE);

           for (Airline airline : getAirlines()) {
               departure.setTime(airline.getDeparture());
               int h1 = departure.get(Calendar.HOUR_OF_DAY);
               int m1 = departure.get(Calendar.MINUTE);
               if (airline.containsDay(day) && (h1 > h2 || (h1 == h2 && m1 > m2))) {
                   count ++;
               }
           }

           Airline[] result = new Airline[count];
           int index = -1;
           for (Airline airline : getAirlines()) {
               departure.setTime(airline.getDeparture());
               int h1 = departure.get(Calendar.HOUR_OF_DAY);
               int m1 = departure.get(Calendar.MINUTE);
               if (airline.containsDay(day) && (h1 > h2 || (h1 == h2 && m1 > m2))) {
                   index++;
                   result[index] = airline;
               }
           }
           return result;
       } catch (ParseException e) {
           return new Airline[0];
       }
   }
}
