package com.proj01.models;

public class Employee {

        private int userId;
        private String empName;
        private long empPhone;
        private String empAddress;
        private String email;


        public Employee(int userId, String empName, long empPhone, String empAddress,String email) {
            this.userId = userId;
            this.empName = empName;
            this.empPhone = empPhone;
            this.empAddress = empAddress;
            this.email = email;
        }

        public Employee() {
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName){
            this.empName = empName;
        }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress){
        this.empAddress = empAddress;
    }

    public long getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(long empPhone){
        this.empPhone = empPhone;
    }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return 
                    "	"+userId +
                    ", 	 " + empName +
                    ",	  " + empAddress +
                    ", 	 " + empPhone +
                    ",	  " + email;
        }
//        @Override
//        public String toString() {
//            return 
//                    "id=" + userId +
//                    ", Name=" + empName +
//                    ", Address=" + empAddress +
//                    ", Phone=" + empPhone +
//                    ", Email=" + email;
//        }
    }


