package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                user = users[index];
                break;
            }
            if (user == null) {
                throw new UserNotFoundException("User is not found");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Invalid login");
        } else if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Login has less than 3 characters");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
            new User("Evgeniy Ivanov", true)
        };
        try {
            User user = findUser(users, "Evgeniy");
            if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
