## Taks
- [x] Payment feature functionality (create, update)
- [x] Radio button not checked on session close
- [x] Payment Details not appearing on user edit page
- [x] Payment history list working (view)
- [x] Delete payment details
- [x] Update payment history db with fk orderid when order db done
- [x] Add query for date/row generated in PaymentHistory db when order submitted 
- [x] Search payment history 
- [x] Update payment details

ALL TASKS DONE


> When order feature done:
>  * Add order_id and order_date to payment history db using ```addPaymentHistory(int userID, int orderID, Date date)``` query in DBManager. 
>  * Add/Update order (payment_date and payment_amount) to payment db once order submitted as well.
