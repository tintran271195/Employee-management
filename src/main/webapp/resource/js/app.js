
class App {
    static BASE_URL_EMPLOYEE = "http://localhost:8080/api/employees";
    static BASE_URL_EMPLOYEETYPE = "http://localhost:8080/api/employee-types";
    static BASE_URL_DEPARTMENT = "http://localhost:8080/api/departments";
    static BASE_URL_POSITION = "http://localhost:8080/api/positions";


    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}
class EmployeeType {
    constructor(id, typeName, department){
        this.id = id;
        this.typeName = typeName;
        this.department = department;
    }
}

class Employee {
    constructor(id, avatar, fullName,gender, dob, email, phone, address, workResume, employeeType, department, position) {
        this.id = id;
        this.avatar = avatar;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
       this.address = address;
       this.workResume = workResume;
       this.employeeType = employeeType;
       this.department = department;
       this.position = position;
    }
}
