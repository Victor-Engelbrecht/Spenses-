package expense

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def addUser(String name, Float balance){
        new User(name: name).addToTransactions(new Transaction(balance:balance,expense: 0,date: new Date()))
                .save()
    }

    def addExpense(String username, Float expense){
        def transaction = new Transaction(balance: 0 ,expense: expense, date: new Date())
        def user = User.findByName(username)

        new user.addToTransactions(transaction)
        user.save()
        //def uid = user.find()

        /*def query = Transaction.where {
            user.id == user
        }

        def saveme = query
        saveme= new Transaction(balance: 0 ,expense: expense, date: new Date())
        saveme.save()*/

        //original code
        /*def user = User.findByName(username)
        user = User.addToTransactions(new Transaction(balance: ,expense: expense, date: new Date()))
        user.save()*/
    }
}
