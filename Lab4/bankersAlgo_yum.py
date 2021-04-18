def bankers(n=0,m=0,avalaible=[],allocation=[[]],max=[[]]):
    #initialization of stuffs
    need=[[x-y for x,y in zip(max[i],allocation[i])] for i in range(n)]
    work=[]
    work[:]=avalaible
    finish=[False]*n
    seq=[]
    i=0
    flag=False
    while len(seq)<n:
        for i in range(n):
            zoom = True
            check = [x - y for x, y in zip(work, need[i])]

            for k in range(len(check)):
                if check[k] < 0:
                    zoom = False
                    break
            if finish[i] == False and zoom:
                work = [x + y for x, y in zip(work, allocation[i])]
                flag=True
                finish[i] = True
                seq.append(i)
        if not flag:
            break

    if len(seq)==n:
        print("safe state with sequence",list(seq))
        #print(list(need))

    else:
        print("unsafe state",list(seq))

allo=[[0,0,1,2],[1,0,0,0],[1,3,5,4],[0,6,3,2],[0,0,1,4]]
max=[[0,0,1,2],[1,7,5,0],[2,3,5,6],[0,6,5,2],[0,6,5,6]]
bankers(5,4,[1,5,2,0],allo,max)






