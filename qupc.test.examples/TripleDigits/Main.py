import json
from TripleDigits import *

TEST_KEY:str = "Test "
INPUT_KEY:str = "Inputs"
EX_OUTPUT_KEY:str = "Expected output"
ACT_OUTPUT_KEY:str = "Actual output"
STATUS_KEY:str = "Status"
PASSED_KEY:str = "PASSED"
FAILED_KEY:str = "FAILED"
JSONFILE_NAME_KEY:str = "Main.output.json"

def main():
    tests = [ [ 2, 2, 8 ], [ 2, 3, 8 ], [ 22, 33, 44 ], [ 3, 5, 7 ], [ 4, 7, 32 ], [ 3, 2, 50 ], [ 12, 6, 470 ], [ 999999999, 128, 1000000 ] ]
    expected = [ "0.500", "001.000", "004.534", "034.714", "512.000", "0.180", "353.157", "000.000" ]
    index:int = 0
    report = {}
    for test in tests:
        data = {}
        data[INPUT_KEY] = test
        data[EX_OUTPUT_KEY] = expected[index]
        obj = TripleDigits()
        res = obj.calculate(test[0], test[1], test[2])
        data[ACT_OUTPUT_KEY] = res
        if res == expected[index]: data[STATUS_KEY] = PASSED_KEY
        else: data[STATUS_KEY] = FAILED_KEY
        index = index + 1
        report[TEST_KEY + str(index)] = data
    #end for
    jsonObj = json.dumps(report)
    with open(JSONFILE_NAME_KEY, "w") as file:
        file.write(jsonObj)

if __name__ == "__main__": main()
