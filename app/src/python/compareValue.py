# -*- coding: utf-8 -*-
# import sys
#导入xlwt模块
import xlwt

# 创建一个Workbook对象，这就相当于创建了一个Excel文件
book = xlwt.Workbook(encoding='utf-8', style_compression=0)


updateFile = 'update.lrs'

randomHigh = "ThinkTimeRandomHigh"

randomLow = "ThinkTimeRandomLow"

totalVusersNumber = "<TotalVusersNumber>"

groupName = "<GroupName>"

config = "Config="
log = "[Log]"

t_dict = {}
f_dict = {}


def read_and_compare_file(file, template):
    with open(template, 'r') as t:
        for line in t:
            if "ScriptName" in line:
                name = line[line.find(":") + 1:]
                # print("tempt name : " + tempt)
                # print("script name equals : " + name)
            if "totalVusersNumber" in line:
                number = line[line.find(":") + 1:]
                t_dict[name.strip()] = number.strip()
                print(name.strip() + ":" + number.strip())
    t.close()

    with open(file, 'r') as f:
        for line in f:
            if groupName in line:
                f_name = line[line.find(">") + 1:line.find("</GroupName>")]
                f_dict[f_name.strip()] = ""
                # print("group Name: "+f_name)

            if totalVusersNumber in line:
                number = line[line.find(">") + 1:line.find("</TotalVusersNumber>")]
                f_dict[f_name.strip()] = number.strip()
                # print(number.strip())
    f.close()

    #遍历file 文件的脚本和TotalVusersNumber
    for index,key in enumerate(f_dict.items()):
        # for k, v in t_dict.items():
        #     if key == k :
        #         if value < v:
        #             #print(key + " 大于阀值 v:" + v +" value:"+value+"\n")
        #         else:
        #             #print(key + " 小于阀值 v:" + v +" value:"+ value+"\n")

        print(index,key[1])

# with open(updateFile, "w") as f:
    #     f.write(file_data)
    # f.close()


if __name__ == '__main__':
    # print("原替换字符串："+sys.argv[1])
    # print("新替换字符串："+sys.argv[2])
    # read_write_file('test.lrs',sys.argv[1],sys.argv[2])
    read_and_compare_file('test.lrs', "template.lrs")
