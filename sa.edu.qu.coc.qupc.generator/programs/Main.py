import json
from Segment import *

TEST_KEY:str = "Test "
INPUT_KEY:str = "Inputs"
EX_OUTPUT_KEY:str = "Expected output"
ACT_OUTPUT_KEY:str = "Actual output"
STATUS_KEY:str = "Status"
PASSED_KEY:str = "PASSED"
FAILED_KEY:str = "FAILED"
JSONFILE_NAME_KEY:str = "Main.output.json"

def main():
	tests1:String[] = ['aabbccdd', 'aaabbaaac', 'abba', 'aabbaaabbbaaaabbbbaaaaaccccc', 'string', '1', 'abccbabbaavbbaac']
	expected:double[] = [2.000000000, 2.250000000, 1.333333333, 3.500000000, 1.000000000, 1.000000000, 1.454545455]
           

    index:int = 0
    report = {}
    for test in tests:
        data = {}
        data[INPUT_KEY] = test
        data[EX_OUTPUT_KEY] = expected[index]
        obj = Segment()
        res = obj.average(tests1[index])              
        data[ACT_OUTPUT_KEY] = res              
        res = abs(res - expected[index]) <= 1.0E-9
        if res == True: data[STATUS_KEY] = PASSED_KEY
        else: data[STATUS_KEY] = FAILED_KEY
        index = index + 1
        report[TEST_KEY + str(index)] = data
    #end for
    jsonObj = json.dumps(report)
    with open(JSONFILE_NAME_KEY, "w") as file:
        file.write(jsonObj)

if __name__ == "__main__": main()
