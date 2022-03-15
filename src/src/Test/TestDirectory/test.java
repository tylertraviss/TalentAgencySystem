// package TestDirectory;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

// import src.src.com.company.Employee;

// public class test {

//     @Test
//     public void testingEmployee() {

//         // Building Employee
//         Employee testEmp = new Employee(
//                 "UserA",
//                 55,
//                 "Female",
//                 "China",
//                 "CEO",
//                 35000,
//                 null,
//                 null,
//                 null);

//         // Testing Initial Entity
//         Assertions.assertEquals(testEmp.getName(), "UserA");
//         Assertions.assertEquals(testEmp.getAge(), 55);
//         Assertions.assertEquals(testEmp.getGender(), "Female");
//         Assertions.assertEquals(testEmp.getNationality(), "China");
//         Assertions.assertEquals(testEmp.getWage(), 35000);
//     }

//     @Test
//     public void testEmployeeClone() {
//         // Generating Test Employee
//         Employee testEmp = new Employee(
//                 "UserA",
//                 55,
//                 "Female",
//                 "China",
//                 "CEO",
//                 35000,
//                 null,
//                 null,
//                 null);

//         // Cloning to Second Employee
//         Employee clonedEmp = testEmp.clone();

//         // Testing Cloned Version
//         Assertions.assertEquals(clonedEmp.getName(), "UserA");
//         Assertions.assertEquals(clonedEmp.getAge(), 55);
//         Assertions.assertEquals(clonedEmp.getGender(), "Female");
//         Assertions.assertEquals(clonedEmp.getNationality(), "China");
//         Assertions.assertEquals(clonedEmp.getWage(), 35000);
//     }

// }
