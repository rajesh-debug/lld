package org.example;

/*
{
  "rules": [
    {
      "id": "rule_id_1",
      "conditions": [
        {
          "expression": "IS_PAYMENT_DONE",
          "operation": "INCLUDES",
          "values": [
            "TRUE"
          ]
        },
        {
          "expression": "PAYMENT_TYPE",
          "operation": "EXCLUDES",
          "values": [
            "CASH"
          ]
        }
      ],
      "operator": "AND",
      "outcome": {
        "header": "text",
        "description": "text",
        "displayType": "BANNER/POP_UP"
      }
    },

    {
      "id": "rule_id_2",
      "conditions": [
        {
          "expression": "IS_PAYMENT_DONE",
          "operation": "INCLUDES",
          "values": [
            "TRUE"
          ]
        },
        {
          "expression": "PAYMENT_TYPE",
          "operation": "EXCLUDES",
          "values": [
            "CASH"
          ]
        }
      ],
      "operator": "OR",
      "outcome": {
        "header": "text",
        "description": "text",
        "displayType": "BANNER/POP_UP"
      }
    }
  ]
}
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}