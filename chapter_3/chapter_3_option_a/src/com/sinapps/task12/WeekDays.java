package com.sinapps.task12;

public enum WeekDays {
    MONDAY ("ПН"),
    TUESDAY ("ВТ"),
    WEDNESDAY ("СР"),
    THURSDAY ("ЧТ"),
    FRIDAY ("ПТ"),
    SATURDAY ("СБ"),
    SUNDAY ("ВС");

    private String title;

    WeekDays(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
