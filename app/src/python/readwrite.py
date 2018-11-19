# -*- coding: utf-8 -*-
#import sys

updateFile = 'update.lrs'

randomHigh = "ThinkTimeRandomHigh"

randomLow = "ThinkTimeRandomLow"

totalVusersNumber = "<TotalVusersNumber>"

groupName = "<GroupName>"

config = "Config="
log = "[Log]"

def read_write_file(file,oldWorld,newWorld):
    file_data = ""
    with open(file, 'r') as f:
        for line in f :
            if "UiName" in line:
                print("script name: "+line.strip())

            if config in line:
                temp = line[line.find(log):]
                temp = temp.split("\\r\\n")
                for t in temp:
                    print(t)

            if groupName in line:
                temp = line[line.find(">")+1:line.find("</GroupName>")]
                file_data += "ScriptName:"+temp+"\n";
                print("group Name: "+temp)

            if totalVusersNumber in line:
                temp = line[line.find(">")+1:line.find("</TotalVusersNumber>")]
                file_data += "totalVusersNumber:"+"100"+"\n\n";
                print("totalVusersNumber:"+temp+"\n")

            if randomHigh in line:
                temp = line[line.find(randomHigh):]
                temp = temp.split("\\r\\n")
                #print(temp)
                print(temp[0])

            if randomLow in line:
                temp = line[line.find(randomLow):]
                temp = temp.split("\\r\\n")
                print(temp[0]+"\n")
            #file_data += line
    f.close()

    with open(updateFile,"w") as f:
        f.write(file_data)
    f.close()

if __name__ == '__main__' :
    #print("原替换字符串："+sys.argv[1])
    #print("新替换字符串："+sys.argv[2])
    #read_write_file('test.lrs',sys.argv[1],sys.argv[2])
    read_write_file('test.lrs',"","")