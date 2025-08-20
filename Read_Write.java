import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Read_Write {
    public void writeplayer(List<Player> profiles) {
        try {
            FileOutputStream files = new FileOutputStream("database99.ser");
            ObjectOutputStream os = new ObjectOutputStream(files);
            for (Player profile : profiles) {
                os.writeObject(profile);
            }
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * public Student readstudent(){
     * Student profile1=null;
     * try{
     * FileInputStream files = new
     * FileInputStream("C:\\Users\\ASUS\\IdeaProjects\\oopproject\\gamedatabase.ser"
     * );
     * ObjectInputStream oi = new ObjectInputStream(files);
     * Object one = oi.readObject();
     * profile1= (Student) one;
     * oi.close();
     * 
     * }catch(IOException | ClassNotFoundException e){
     * e.printStackTrace();
     * }
     * 
     * return profile1;
     * }
     */
    public Player[] readplayerarr() {
        Player[] sarr = null; // Initialize the array to null

        try {
            FileInputStream files = new FileInputStream(
                    "database99.ser");
            ObjectInputStream oi = new ObjectInputStream(files);

            // Initialize a list to store all students
            List<Player> studentList = new ArrayList<>();

            // Read objects until end of file is reached
            while (true) {
                try {
                    Object obj = oi.readObject();
                    if (obj instanceof Player) {
                        Player student = (Player) obj;
                        studentList.add(student); // Add student to the list
                    }
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }

            oi.close();

            // Convert the list to an array
            sarr = studentList.toArray(new Player[0]);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sarr;
    }
}
