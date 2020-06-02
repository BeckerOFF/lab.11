package bogdan;

import java.io.Serializable;

public class Manager extends Employee  implements Serializable {
    private double bonus;

    public Manager(){}
    public Manager(int id, String name, String surname, double salary,double bonus ) {
        super(id, name, surname, salary);
        this.bonus = bonus;
    }
    public Manager(int id, String name, String surname, double salary,double bonus,Manager manager ){
        super(id, name, surname, salary, manager);
        this.bonus=bonus;
    }



    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString()
    {
        return "manager: id- " + getId() + ", name- " + getName() + ", surname- " + getSurname() + ", salary- " + getSalary() + ", bonus- " + getBonus()  ;
    }
}
