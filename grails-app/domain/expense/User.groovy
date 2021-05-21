package expense

class User {

    String  name
    //possibly use add list of books 5.2.4 Sets,lists and maps under "lists of objects"
    static hasMany = [transactions: Transaction]
    static constraints = {
    }
}

class Transaction {

    int balance
    int expense
    String date

    static belongsTo = [user : User]
    static constraints = {
    }
}