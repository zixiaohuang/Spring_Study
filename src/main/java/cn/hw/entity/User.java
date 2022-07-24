package cn.hw.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;

public class User {
    @NotNull
    @Min(value = 1, message = "id必须大于0")
    private Integer id;
    @NotEmpty
    @Length(min=4, max = 8, message = "用户名的长度必须在{min}和{max}之间")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "用户名只能输入0-9或者a-z")
    private String username;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double balance; //  ¥5000
    private String[] hobbies;
    @NumberFormat(pattern = "#,###.##")
    @Range(min=2000, max = 1000000, message = "工资必须在{min}和{max}之间") // Size的范围是int 不能用于验证Double
    private Double salary; // 工资 10,000.00
    @Range(min=0, max=100, message = "任务完成度必须在") // Range的范围是long 所以Range可以控制的范围更大
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private Double taskCount; // 任务完成百分比 90%

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Double taskCount) {
        this.taskCount = taskCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", salary=" + salary +
                ", taskCount=" + taskCount +
                '}';
    }
}
