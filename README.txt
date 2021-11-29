1.  (Seung Jung / Daniel O'Donnell) Issue: The model class "customer" is empty and does not do anything.
    Solution: Created attribute data with getters and setters for customers.

2.  (Daniel O'Donnell) Issue: The model class "Employee" is empty and does not do anything.
    Solution: The Employee class was revised to include attributes with encapsulation that includes getters/setters.

3.  (David Hernandez) Issue: UserController class is the longest Java class that we have at 123 lines.
    Solution:
The class UserController was split into two classes, UserController and LoginSignUpController. 
The methods login2 and signUp were moved from UserController and moved to LoginSignUpController.
This change was made in order to reduce the size of UserController to make the class easier to understand.

4.  (Daniel O'Donnell) Issue: There are no comments in the code
    Solution: Added comments in all classes and included a main heading.

5.  (Daniel O'Donnell) Issue: The model class "LoanApplication" lacks logical statements to retrieve various loan app types.
    Solution: method retrieveLoanAppType() was added with logical statemenets to handle switching between loan application types.

6.  (David Hernandez) Issue: The service class "LoanServiceImpt" has many methods.
    Solution:
    Because the class "LoanServiceImpt" is based on the interface "LoanService", creating a separate class would cause errors, so the program would not be able to run.
    This happens because Java makes it mandatory to implement all of the methods in an interface, so the class has to have all of them.
    Some methods in the class rely on previous methods to work, so splitting them apart would cause the software to not work since they are connected by an interface.
    Even if we made separate the interfaces, it would cause trouble for the classes since their methods would try to find what does not exist in their interface and class.

7.  (David Hernandez) Issue: The service class "UserServiceImpl" has many methods.
    Solution:
    Because the class "UserServiceImpl" is based on the interface "UserService", creating a separate class would cause errors, so the program would not be able to run.
    This happens because Java makes it mandatory to implement all of the methods in an interface, so the class has to have all of them.
    Some methods in the class rely on previous methods to work, so splitting them apart would cause the software to not work since they are connected by an interface.
    Even if we made separate the interfaces, it would cause trouble for the classes since their methods would try to find what does not exist in their interface and class.

8.  (Seung Jung) Issue: The html code for Customer Screen does not do anything productive except display a title page but no content.
    Solution:

9.  (Jennifer Lewis) Issue: Easy to have access to Employee dashboard.
    Solution: Changed the employee signup string to one that's less generic and easily detectable. 

10. (Jennifer Lewis) Issue: Employee dashboard doesn't display the "customers" that have signed up.
    Solution: Added HTTP GET Requests to save and retrieve customer/loanee data to the employee data screen. 
