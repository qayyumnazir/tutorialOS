
def alloc():
    start=int(input("Please enter starting block    "))
    length=int(input("Please enter length of the file    "))
    x=start
    count=0
    while x<(start+length):
        if mem[x]==0:
            count+=1
        x+=1
    if count==length:
        j=start
        while j < (start + length):
            mem[j]=1
            print("Block ",j," is allocated to ",mem[j])
            j+=1
        print("The file is allocated")
    else:
        print("The file is not allocated")

size=int(input("Please enter the size of the memory   "))
mem=[0]*size
flag=1
while flag==1:
    alloc()
    flag=int(input("Do you want to enter more file? (1/yes)(0/no)"))






