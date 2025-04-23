package com.rule_engine.core;

import java.util.Map;

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

import com.rule_engine.model.*;

import java.util.List;

public class RuleEngineManagerTest {

    public static void main(String[] args) throws Exception {

        RuleEngineService ruleEngineService = setUp();

        // Initialize RuleEngineManager
        RuleEngineManager manager = new RuleEngineManager(ruleEngineService);

        // Define expressions
        Expression expr1 = new Expression("country");
        Expression expr2 = new Expression("device");

        // Define input
        Map<Expression, List<String>> input = Map.of(expr1, List.of("IN"), expr2, List.of("desktop"));

        // Evaluate
        Outcome result = manager.evaluate(input, List.of("rule1", "rule2"));

        // Print outcome
        if (result != null) {
            System.out.println("Header: " + result.getHeader());
            System.out.println("Description: " + result.getDescription());
            System.out.println("Display Type: " + result.getDisplayType());
        } else {
            System.out.println("No applicable rule found.");
        }
    }

    private static RuleEngineService setUp() throws Exception {
        // Define expressions
        Expression expr1 = new Expression("country");
        Expression expr2 = new Expression("device");

        // Define conditions
        Condition condition1 = new Condition(expr1, Operation.INCLUDES, List.of("IN"));
        Condition condition2 = new Condition(expr2, Operation.EXCLUDES, List.of("mobile"));

        // Define outcomes using new constructor
        Outcome outcome1 = new Outcome("Access Granted", "User is from India and not using a mobile device", "GREEN_BANNER");

        Outcome outcome2 = new Outcome("Access Denied", "User location or device not permitted", "RED_BANNER");

        // Define rules
        Rule rule1 = new Rule("rule1", Operator.AND, List.of(condition1, condition2), outcome1);
        Rule rule2 = new Rule("rule2", Operator.OR, List.of(condition1), outcome2);

        // Setup RuleEngineService with rules
        return new RuleEngineService(Map.of("rule1", rule1, "rule2", rule2));

    }
}
