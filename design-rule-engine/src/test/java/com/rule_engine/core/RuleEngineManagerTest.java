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
class RuleEngineManagerTest {


    public static void main(String[] args) {
        RuleEngineService ruleEngineService = new RuleEngineService(Map.of());
        RuleEngineManager ruleEngineManager = new RuleEngineManager(ruleEngineService);
    }

}