import json
from Marking import *

TEST_KEY:str = "Test "
INPUT_KEY:str = "Inputs"
EX_OUTPUT_KEY:str = "Expected output"
ACT_OUTPUT_KEY:str = "Actual output"
STATUS_KEY:str = "Status"
PASSED_KEY:str = "PASSED"
FAILED_KEY:str = "FAILED"
JSONFILE_NAME_KEY:str = "Main.output.json"

def main():
    Ms =[ [ [ 10, 20, 30 ], [ 40, 50, 60 ], [ 70, 80, 90 ] ], [ [ 10, 20, 10 ], [ 50, 40, 20 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 40, 60 ], [ 10, 20, 10 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 10, 60 ], [ 30, 20, 40 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 40, 60 ], [ 10, 20, 10 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 40, 60 ], [ 10, 20, 10 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 40, 60 ], [ 10, 20, 10 ] ], [ [ 90, 80, 20 ], [ 70, 60, 30 ], [ 50, 40, 60 ], [ 10, 20, 10 ] ] ]
    manys = [ [ 1, 2, 1 ], [ 1, 1 ], [ 0, 1, 2, 3 ], [ 0, 1, 2, 3 ],[ 1, 0, 3, 2 ], [ 1, 1, 1, 1 ], [ 0, 1, 0, 0 ], [ 0, 0, 0, 0 ] ]
    expected = [ 180, 70, 170, 150, 190, 210, 70, 0 ]
    index:int = 0
    report = {}
    for index in range(0,len(expected),1):
        data = {}
        inputs = 'inputs=[' + str(','.join(map(str, Ms[index]))) + ']'
        inputs += ', many=[' + str(','.join(map(str,manys[index]))) + ']'
        data[INPUT_KEY] = inputs
        data[EX_OUTPUT_KEY] = expected[index]
        obj = Marking()
        res = obj.totalBestMarks(Ms[index], manys[index])
        data[ACT_OUTPUT_KEY] = res
        if res == expected[index]: data[STATUS_KEY] = PASSED_KEY
        else: data[STATUS_KEY] = FAILED_KEY
        index = index + 1
        report[TEST_KEY + str(index)] = data
    #end for
    jsonObj = json.dumps(report)
    with open(JSONFILE_NAME_KEY, "w") as file: file.write(jsonObj)

if __name__ == "__main__": main()
