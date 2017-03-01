public class GPA{
    public static void main(String[] args){
        //create a symbol table of grades and values
        ST<String, Double> grades = new ST<String, Double>(); 
        //add the values to the table
        grades.put("A", 4.00);
        grades.put("B", 3.00);
        grades.put("C", 2.00);
        grades.put("D", 1.00);
        grades.put("F", 0.00);
        grades.put("A+", 4.33);
        grades.put("B+", 3.33);
        grades.put("C+", 2.33);
        grades.put("D", 1.33);
        grades.put("A-", 3.67);
        grades.put("B-", 2.67);

        //read the grades from standard input and compute the GPA
        int n = 0;
        double total = 0.0;
        for(n = 0; !StdIn.isEmpty();n++){
            String grade - StdIn.readString();//reads the grade
            double value = grades.get(grade);//checks the table for the int value 
            total += value; //add the numberic grade to value
        }
        double GPA = total/n;
        StdOut.println("GPA=" + GPA);
    }
}

