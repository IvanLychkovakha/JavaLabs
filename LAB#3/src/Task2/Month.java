package Task2;

public enum Month {
    Січень (31),
    Лютий (28),
    Березень (31),
    Квітень (30),
    Травень (31),
    Червень (30),
    Липень (31),
    Серпень (31),
    Вересень (30),
    Жовтень (31),
    Листопад (30),
    Грудень (31);
    private Integer days;
    public int getDay() {
        return days;
    }
    private Month(Integer days) {
        this.days=days;
    }
    public static void soutAll() {
        Month a = Month.Грудень;
        for (int i = 0; i < 12; i++) {
             a = a.next();
            System.out.println(a + " " + a.getDay());
        }
    }
   public Month next() {
        Month day = values()[(ordinal() + 1) % values().length];
        return day;
    }

   public Month last() {
        Month day = values()[(ordinal() - 1) % values().length];
        return day;
    }
    public String Season() {
        switch (this) {
            case Грудень:
            case Січень:
            case Лютий:
                return "Winter";
            case Вересень:
            case Жовтень:
            case Листопад:
                return "Autumn";
            case Березень:
            case Квітень:
            case Травень:
                return "Spring";
            default:
                return "Summer";
        }
    }
}
