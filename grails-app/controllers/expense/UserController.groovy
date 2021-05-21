package expense


class UserController {

    //scaffolding
    static scaffold = User
    // declaring services
    def userService
    def testService
    def currencyConversion
    def addUser(String name , Float balance){
        userService.addUser(name, balance)
        render (view:"home", model:[user: userService])
    }

    def addExpense(String name, Float expense){
        userService.addExpense(name, expense)
        render(view: "Expense", model:[user: userService])
    }

    def convert(Float test) {
        currencyConversion = testService.currencyConversion(test)
        render(view: "home", model: [currencyConversion: currencyConversion])
    }
}

class TransactionController {

    static scaffold = Transaction

}
