import json
from MatrixDiagonalSum import *

TEST_KEY:str = "Test "
INPUT_KEY:str = "Inputs"
EX_OUTPUT_KEY:str = "Expected output"
ACT_OUTPUT_KEY:str = "Actual output"
STATUS_KEY:str = "Status"
PASSED_KEY:str = "PASSED"
FAILED_KEY:str = "FAILED"
JSONFILE_NAME_KEY:str = "Main.output.json"

def main():
    tests = [ [[1, 2, 3],[4, 5, 6],[7, 8, 9]], [[2, 0, 0],[0, 2, 0],[0, 0, 2]], [[3, 5],[8, 2]], [[1, 0, 0, 0],[0, 1, 0, 0],[0, 0, 1, 0],[0, 0, 0, 1]], [[9]], [[1, 2, 3, 4],[5, 6, 7, 8],[9, 10, 11, 12],[13, 14, 15, 16]], [[5, 0, 0, 0, 0],[0, 5, 0, 0, 0],[0, 0, 5, 0, 0],[0, 0, 0, 5, 0],[0, 0, 0, 0, 5]], [[1, 0, 0],[0, 2, 0],[0, 0, 3]], [[10, -2],[-3, 20]], [[0, 0],[0, 0]]]
    expected = [ 15, 6, 5, 4, 9, 34, 25, 6, 30, 0]
    index:int = 0
    report = {}
    for test in tests:
        data = {}
        data[INPUT_KEY] = test
        data[EX_OUTPUT_KEY] = expected[index]
        obj = MatrixDiagonalSum()
        res = obj.getMainDiagonalSum(test)
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
