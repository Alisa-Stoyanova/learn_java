package codecademy;

class Timecard {
    public String firstname;
    public String lastname;
    public int date;
    public String id;

    public Timecard(String firstname, String lastname, int date, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Timecard t = (Timecard) o;
        if (id.equals(t.id) && date == t.date) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // declare and instantiate
        Timecard timecardSearch = new Timecard("Jennifer", "Smith", 11032020, "jSmith");
        Timecard timecard1 = new Timecard("Jennie", "Jones", 1102020, "jJones");
        Timecard timecard2 = new Timecard("Jennifer", "Tompkins", 11022020, "jTompkins");
        Timecard timecard3 = new Timecard("Jen", "Smith", 11032020, "jSmith");
        Timecard timecard4 = new Timecard("Jenny", "Lawrence", 11032020, "jLawrence");
        Timecard timecard5 = new Timecard("Jenn", "Williams", 11042020, "jWilliams");

        // comparisons
        System.out.println(timecardSearch.equals(timecard1));
        System.out.println(timecardSearch.equals(timecard2));
        System.out.println(timecardSearch.equals(timecard3));
        System.out.println(timecardSearch.equals(timecard4));
        System.out.println(timecardSearch.equals(timecard5));
    }
}

/*class Timecard {
  public String firstname;
  public String lastname;
  public int date;
  public String id;
  public Timecard (String firstname, String lastname, int date, String id) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.date = date;
    this.id = id;
  }

  public boolean equals(Timecard t) {
    if(this.id.equals(t.id)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
  // declare and instantiate
  Timecard timecardSearch = new Timecard("Jennifer", "Smith", 11032020, "jSmith");
    Timecard timecard1 = new Timecard("Jennie", "Jones", 1102020, "jJones");
    Timecard timecard2 = new Timecard("Jennifer", "Tompkins", 11022020, "jTompkins");
    Timecard timecard3 = new Timecard("Jen", "Smith", 11032020, "jSmith");
    Timecard timecard4 = new Timecard("Jenny", "Lawrence", 11032020, "jLawrence");
    Timecard timecard5 = new Timecard("Jenn", "Williams", 11042020, "jWilliams");

  // comparisons
  System.out.println(timecardSearch.equals(timecard1));
  System.out.println(timecardSearch.equals(timecard2));
  System.out.println(timecardSearch.equals(timecard3));
  System.out.println(timecardSearch.equals(timecard4));
  System.out.println(timecardSearch.equals(timecard5));
  }
}*/