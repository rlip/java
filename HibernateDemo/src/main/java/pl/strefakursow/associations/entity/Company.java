package pl.strefakursow.associations.entity;

import pl.strefakursow.hibernatedemo.entity.Employee;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_company")
    private Integer idCompany;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private Integer value;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="id_company_detail")
    private CompanyDetail companyDetail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Property> properties;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_company")
    private Set<Department> departments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "employee_training", joinColumns = @JoinColumn(name = "id_employee"), inverseJoinColumns = @JoinColumn(name="id_training"))
    private List<Employee> employee;

    public Company() {
    }

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public List<Property> getProperties() {
        return properties;
    }


    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public void addEmployee(Employee employee){
        if(this.employee == null){
            this.employee = new ArrayList<Employee>();
        }
        this.employee.add(employee);
    }

    public void addProperty(Property property){
        if(this.properties == null){
            this.properties = new ArrayList<Property>();
        }
        this.properties.add(property);
        property.setCompany(this);
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public CompanyDetail getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        if(this.departments == null){
            this.departments = new HashSet<Department>();
        }
        this.departments.add(department);
    }
}
