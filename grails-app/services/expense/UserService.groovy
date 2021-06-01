package expense

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def addUser(String name, Float balance){
        new User(name: name).addToTransactions(new Transaction(balance:balance,expense: 0,date: new Date()))
                .save()
    }
    /*
    find the user  (this is done)
    balance in account (this is done)
    insert new transaction
    */
    def addExpense(String username, Float expense){
        def findUser = User.findByName(username)

        if (findUser != null){
            def query = Transaction.where {
                id == max(id).of {user == findUser}
                //id==max(user.transaction)
            }
            def tBalance = query.balance.find()
            def tExpense = query.expense.find()
            def newBalance = (tBalance-tExpense)
            def transaction = new Transaction(balance:newBalance, expense: expense, date: new Date())
            def test = findUser.addToTransactions(transaction)
            test.save()


            /*transaction.user = [name:username]
            transaction.save()*/

            /*findUser.addToTransactions(transaction)
                    .save()*/

            println    "HERE $test"
        }
        else{
            return null
        }
        println    "HERO $findUser"



        /*def transaction = new Transaction(balance: 0 ,expense: expense, date: new Date())
        def user = User.findByName(username)
        new user.addToTransactions(transaction)
        user.save()*/
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
