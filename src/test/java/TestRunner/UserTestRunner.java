package TestRunner;

import User.User;
import io.qameta.allure.Allure;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class UserTestRunner {
    User user;

    @Test(priority = 0, description = "Calling the login API by giving valid credentials")
    public void doLogin() throws IOException, ConfigurationException {
        User user = new User();
        user.callingLoginAPI("salman@grr.la","1234");
        String messageExpected ="Login successfully";
        Assert.assertEquals(user.getMessage(),messageExpected);
    }
    //*@Test
    //public void getUserList2() throws IOException {
    //    user = new User();
     //   String id = user.callingUserListAPI();
      //  System.out.println(id);
     //   Assert.assertEquals(id,String.valueOf(81));
    //}

    @Test(priority = 1,description = "Incorrect Email provides for login")
    public void incorrectEmail() throws IOException {
        user=new User();
        user.incorrectEmail();
        Allure.description("Will give 'User not found' and status '404' if incorrect email is provided");
    }
    @Test(priority = 2,description = "Incorrect password provides for login")
    public void incorrectPassword() throws IOException {
        user=new User();
        user.incorrectPassword();
        Allure.description("Will give 'password incorrect' and status '401' if incorrect password is provided");
    }
    @Test(priority = 3,description = "No password provides for login")
    public void blankPassword() throws IOException {
        user=new User();
        user.blankPassword();
        Allure.description("Will give 'blank password' and status '401' if no password is provided");
    }
    @Test(priority = 4,description = "user list will be extracted by giving proper authorization")
    public void getUserList() throws IOException {
        user=new User();
        user.getUserList();
        Allure.description("After giving proper authorization token user list will be extracted where the status code is 200, the first id of the user is 58 and the message is 'User List");
    }
    @Test(priority = 5,description = "incorrect token provides for User list")
    public void getUserListForIncorrectToken() throws IOException {
        user=new User();
        user.getUserListForIncorrectToken();
        Allure.description("After giving incorrect token user list will be extracted where the status code is 403, and the message is 'Token expired!'");
    }
    @Test(priority = 6,description = "blank token provides for User list")
    public void getUserListForBlankToken() throws IOException {
        user=new User();
        user.getUserListForBlankToken();
        Allure.description("After giving blank token user list will be extracted where the status cod is 401 and the message is 'No Token Found!'");
    }
    @Test(priority = 7,description = "New User create")
    public void CreateUser() throws ConfigurationException, IOException {
        user=new User();
        user.CreateUser();
        Allure.description("he user is created through Authorization and secret key, name,email,password,phone_number,nid and role is set uniquely.\" +\n" +
                "                \"Status code is 201 as created new user and 'User created successfully will be generated");
    }
    @Test(priority = 8,description = "User has Already Exists")
    public void AlreadyExistsUser() throws IOException {
        user=new User();
        user.AlreadyExistsUser();
        Allure.description("Already user has exists and status code is 208 and 'User already exists'");
    }
    @Test(priority = 9,description = "Search User by id")
    public void searchUser() throws IOException {
        user=new User();
        user.searchUser();
        Allure.description("Search user using stored id will give status as 200 and user id shall be equal to the stored id in the environment variable");
    }
    @Test(priority = 10, description = "Search user for invalid id")
    public void searchUserForInvalidId() throws IOException {
        user = new User();
        user.searchUserForInvalidId();
        Allure.description("Search user for invalid id should give 401 as status code and user should be null ");
    }
    @Test(priority = 11,description = "User updated")
    public void updateUser() throws IOException {
        user=new User();
        user.updateUser();
        Allure.description("User update a account and status code is 200 and 'user update!'");
    }
    @Test(priority = 12,description = "Update a phone number by id")
    public void updateUserPhoneNumber() throws IOException {
        user=new User();
        user.updateUserPhoneNumber();
        Allure.description("User update a phone number by id and status code is 200 and 'user update!'");
    }
    @Test(priority = 13,description = "Delete user")
    public void deleteUser() throws IOException {
        user=new User();
        user.deleteUser();
        Allure.description("Deleting user using the stored Id in the variables , status code 200 will be returned and 'user deleted successfully' message will be derived");
    }
    @Test(priority = 14,description = "Already Deleted User")
    public void alreadyDeletedUser() throws IOException {
        user=new User();
        user.alreadyDeleteUser();
        Allure.description("Already deleted user cannot be deleted again and status code of 404 will be returned and 'user not found' message will be derived");

    }
}
