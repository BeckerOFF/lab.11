package bogdan;

import java.io.Serializable;

public class Employee  implements Serializable {
    private int id;
    private String name;
    private String surname;
    private double salary=1000;
    private Manager manager;

    public Employee(){}

    public int getId(){
        return  id;
    }

    public void setId(int a){
        id=a;
    }

    public String getName(){
        return name;
    }

    public void setName(String b){
        name=b;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String c){
        surname=c;
    }

    public void setSalary(double d){
        salary=d;
    }
    public double getSalary(){
        return salary;
    }
    public Manager getManager(){return manager;}


    public Employee(int id, String name, String surname, double salary){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.salary=salary;
    }
    public Employee(int id, String name, String surname, double salary, Manager manager){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.salary=salary;
        this.manager=manager;
    }

    public double raiseSalary(int n){
        return salary*(double)n;
    }

    public String toString()
    {
        return "Our employee: id - " + id + ", name - " + name + ", surname - " + surname + ", salary - " + salary + ", manager of this employee - "+getManagerName();

    }
    public final String getManagerName()
    {
        if (manager==null)
            return "Nomanager";
        else
            return  manager.toString();

    }

    public Employee getTopManager(){
        if(manager == null){
            return this;
        } else {
            return getManager().getTopManager();
        }
    }


}
