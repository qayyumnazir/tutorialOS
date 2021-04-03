def sjf(num,time=[]):



    time=sorted(time)

    current=0
    print(time)
    for i in time:
        current+=int(i)
        wait=current-int(i)
        if wait<0:
            wait=0
        turn=wait+int(i)

        print("size : ",i)
        print("wait : ", wait)
        print("turn : ", turn)
        print('-------------')




numb=input("Please enter the number of jobs: ")
i=0
k=[]
while i < int(numb):
    strtemp='Please enter the job number {} size : '.format(int(i)+1)
    temp=int(input(strtemp))
    k.append(temp)
    i+=1

sjf(numb,k)



