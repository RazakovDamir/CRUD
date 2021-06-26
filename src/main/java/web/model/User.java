package web.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   @Column(name = "name")
   private String name;
   @Column(name = "lastname")
   private String lastname;
   @Column(name = "age")
   private long age;

   public User() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public long getAge() {
      return age;
   }

   public void setAge(long age) {
      this.age = age;
   }
}