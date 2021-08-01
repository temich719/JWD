package JWD.com;

public class Executor extends Computing{

    private static boolean flag = false;

    private void stop(){ flag = true; }

    public void execute(){
        while (!flag){
            Menu.printMenu();
            if(scanner.nextLine().charAt(0) == '2'){
                Menu.lastMessage();
                stop();
            }
            else {
                Menu.inputFirstOperand();
                String firstOperand = getOperand();
                sign = defineSign();
                if(sign == 's'){
                    System.out.println("Ответ:  sqrt" + firstOperand +
                            + compute(Integer.parseInt(firstOperand),0,sign));
                }
                else {
                    Menu.inputSecondOperand();
                    String secondOperand = getOperand();
                    System.out.println("Ответ:  " + firstOperand + " " + sign + " " + secondOperand + " = "
                            + compute(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand), sign));
                }
            }
        }
    }
}
