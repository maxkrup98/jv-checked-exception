package core.basesyntax;

public class UserService {
    private PasswordValidator passwordValidator;

    public UserService() {
        this.passwordValidator = new PasswordValidator();
    }

    public void registerUser(User user) {
        if (user.getPassword() == null && user.getRepeatPassword() == null) {
            System.out.println("Error: Password doesn't exist.");
            return;
        }
        try {
            passwordValidator.validate(user.getPassword(), user.getRepeatPassword());
            saveUser(user);
        } catch (PasswordValidationException e) {
            System.out.println("Your passwords are incorrect. Try again.");
        }
    }

    public void saveUser(User user) {
        System.out.println("User " + user.toString() + " was saved to database!!!");
    }
}
