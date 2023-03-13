import java.util.*;

public class StringBasics {
    public static void printChars(String str) {
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);

        String firstName = "Tony";
        String lastName = "Stark";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        System.out.println(fullName.length());
        System.out.println(fullName.charAt(0));
    }
}

// git queries
// git init
// git add README.md
// git commit -m "first commit"
// git branch -M main
// git remote add origin git@github.com:Sandeepmoorani/Placement.git
// git push -u origin main
// git remote add origin git@github.com:Sandeepmoorani/Placement.git
// git branch -M main
// git push -u origin main