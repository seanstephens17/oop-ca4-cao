//Sean Stephens D00211442

package dkit.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Notes:
 *  Synchronisation of multiple reads and writes to file is not considered here.
 *
 */
public class App 
{
    private static Scanner sc = new Scanner(System.in);


    public static void main( String[] args )
    {
        System.out.println( "CAO Online - CA4" );
        new App() .start();
    }

    private void start() {

        // load students
        StudentManager studentManager = new StudentManager();

        // load courses
        CourseManager courseManager= new CourseManager();

        // load manager to provide functionality to allow a student
        // to login and add/update their course selections
        // This CourseChoicesManager component depends on the
        // StudentManager and the CourseManager,
        // so we 'inject' or pass-in these objects.
        //
        CourseChoicesManager mgr = new CourseChoicesManager(studentManager, courseManager);

        //STORING CHOICES FOR STUDENT
        ArrayList<String> list = new ArrayList<>();
        list.add("DK821");
        list.add("DN150");
        list.add("TUD350");
        //add/update students choices
        mgr.updateChoices(1234567, list);
        //get the students current choices
        List<String> currentChoicesList = mgr.getStudentChoices(1234567);
        //display the students choice. iterate over currentChoicesList
         mgr.getCourseDetails("DK321");
         mgr.getStudentChoices(1234567);
         mgr.getStudentDetails(1234567);



        // display a menu to do things
        // manual testing of mgr public interface
        while(true){
            //show options
            System.out.println("0. Exit");
            System.out.println("1. Get a Student Using Cao Number");
            System.out.println("2. Get a Course Using the course ID");
            System.out.println("3. Get a Students Choices using their Cao Number");
            System.out.println("4. Update a Students Choices");
            System.out.println("5. View all Courses");
            System.out.println("6. View all Students");

            String input = sc.nextLine();


            try{
                int inp = Integer.parseInt(input);

                switch( inp ){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Please Enter a Cao Number: ");
                        Integer caoNumber = sc.nextInt();
                        System.out.println(mgr.getStudentDetails(caoNumber));
                        break;
                    case 2:
                        System.out.println("Please Enter a Course ID: ");
                        String courseID = sc.nextLine();
                        mgr.getCourseDetails(courseID);
                        break;
                    case 3:
                        System.out.println("Please Enter a Cao Number: ");
                        Integer caoNumber2 = sc.nextInt();
                        mgr.getStudentChoices(caoNumber2);
                        break;
                    case 4:
                        System.out.println("Please Enter a Cao Number: ");
                        Integer caoNumber3 = sc.nextInt();
                        //mgr.updateChoices(caoNumber3,"DK821");
                        break;
                    case 5:
                        System.out.println("All Courses");
                        mgr.printAllCourses();
                        break;
                    case 6:
                        System.out.println("All Students");
                        mgr.printAllStudents();
                        break;
                    default:
                        System.out.println("Not a valid option");
                        System.out.println("Please try again...");

                }


            }catch(NumberFormatException e){
                System.out.println("Not a Number");
                System.out.println("Please try again...");
            }
        }






        //menu();


//        if ( mgr.login(22224444, "xxxx","bbbb") )
//        {
//            Student student = mgr.getStudentDetails(22224444);
//
//            System.out.println("Student: " + student);
//        }
//        else
//            System.out.println("Not logged in - try again");


        //mgr.saveToFile();

    }
}
