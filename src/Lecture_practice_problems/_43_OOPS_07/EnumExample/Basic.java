package Lecture_practice_problems._43_OOPS_07.EnumExample;

public class Basic{
    enum  Week implements A{
        // enum can neither extend another class nor can be inherited as it is final but, it can implement as many interfaces it wants
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public, static and final
        // since it is final we can't create child enums
        // type is Week

        Week(){
            System.out.println("Constructor called for " + this.toString());
        }

        @Override
        public void greet() {
            System.out.println("Hey how are you ?");
        }
        // this is not public or protected, only private or default
        // why? we don't want to create new objects
        // this is not the enum concept, that's why

        // internally: public static final Week Monday = new Week();
    }

    public static void main(String[] args) {
        Week week;
        week=Week.Friday;

//        for(Week day: Week.values()){
//            System.out.println(day);
//        }
//        System.out.println(week);
//        System.out.println(week.ordinal());
        week.greet();
    }
}
