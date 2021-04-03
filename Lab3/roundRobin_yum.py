def roundRobin(num=0,time=[0],quantum=0):

    rbt=[]
    rbt[:]=time
    flag = [1] * num
    wait=[0]*num
    cmp=[0]*num


    i=0
    curr=0
    while 1 in flag:

        print(rbt)
        #print(wait)

        if flag[i] == 1:
            if quantum < (rbt[i]):
                rbt[i]-=quantum
                curr+=quantum
            else :
                curr+=rbt[i]
                rbt[i]=0
            if rbt[i]==0:
                flag[i]=0
                cmp[i]=curr
                continue


        if i == num-1 :
            i=0
        else :
            i+=1

    for i in range(num):
        wait[i]=cmp[i]-time[i]

    ttl=0
    print("BURST TIME       WAIT TIME       TURN AROUND TIME")
    for i in range(num):
        print("    {}                {}                    {}      ".format(time[i],wait[i],cmp[i]))
        ttl+=wait[i]
    print("The Average wait time is ",ttl/num)


numb=input("Please enter the number of jobs: ")
i=0
k=[]
while i < int(numb):
    strtemp='Please enter the job number {} size : '.format(int(i)+1)
    temp=int(input(strtemp))
    k.append(temp)
    i+=1
qtm=input("Please enter quantum: ")

roundRobin(int(numb),k,int(qtm))



