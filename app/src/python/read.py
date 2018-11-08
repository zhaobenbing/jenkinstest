# -*- coding: utf-8 -*-


updateFile = 'update.txt'

def read_write_file(file):
    file_data = ""
    with open(file, 'r') as f:
        for line in f :
            if "123" in line:
                line = line.replace("123","abc")
            print(line) # 输出语句
            file_data += line
    f.close()

    with open(updateFile,"w") as f:
        f.write(file_data)
    f.close()

if __name__ == '__main__' :
 read_write_file('/Users/zhaobenbing/Desktop/B1805_BizX_MULT_PostRelease_3000.lrs')