package employee;

public class Employee {
private String name;
private String phone;
private int dept;
private int id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", phone=" + phone + ", dept=" + dept + ", id=" + id + "]";
}
public Employee(String name, String phone, int dept) {
	super();
	this.name = name;
	this.phone = phone;
	this.dept = dept;
}

public Employee(String name, String phone, int dept, int id) {
	super();
	this.name = name;
	this.phone = phone;
	this.dept = dept;
	this.id = id;
}
public int getDept() {
	return dept;
}
public void setDept(int dept) {
	this.dept = dept;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
