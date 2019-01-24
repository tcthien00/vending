Finite State Machines: Vending Machine
Design and implement FSM that mimics a simple vending machine. 

 
The detailed functionality of the vending machine is as follows:  
The top level interface to the vending machine polls the user interface for input coins, key to the selection of desired item and also for a reset key to give back all the input coins. Output of the vending machine must display progressively the value of coins inserted. If the user selects an item and has inserted sufficient funds, then the item will be dispensed and total count of the item should be decremented to display the remaining inventory. Remaining funds, if any must be displayed to the user. 
1.	The vending machine accepts only the following coin denominations:  nickels, dimes or quarters. Assign unique character key to represent each coin input denomination. Assign a special key to simulate the valid entry of a coin into the system. 
2.	As coins are entered, a running total is displayed on the console output screen. 
3.	The vending machine contains the following inventory: 
•	Item 1 which costs 55 cents 
•	Item 2 which costs 70 cents 
•	Item 3 which costs 75 cents 
•	Each item begins with an inventory count of 10. 
4.	If the user has not inserted sufficient funds and intends to purchase an item, the system should alert the user and return the coins inserted.  
5.	You can limit the total funds that the system can take in at a time to be 1 dollars. 
6.	The system should have a “coin return” key that will return all inserted funds and reset the vending machine. 
For the vending machine implemented above, provide the state diagram and a brief description about the implementation. Use Java console for input and output operations. 
