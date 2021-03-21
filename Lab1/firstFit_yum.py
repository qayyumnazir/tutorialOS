# Implementation:
# 1- Input memory blocks with size and processes with size.
# 2- Initialize all memory blocks as free.
# 3- Start by picking each process and check if it can
#    be assigned to current block.
# 4- If size-of-process <= size-of-block if yes then
#    assign and check for next process.
# 5- If not then keep checking the further blocks

def firstfit(memories=[],program_amount=0,program_size=[],):
    block=[]
    print("Process No.    Process Size   Block no")
    block= [False] * len(memories)
    for i in range(len(program_size)):
        for j in range(len(memories)):
            if program_size[i]<memories[j] and not block[j]:
                block[j]=True
                print(i+1,"            ",program_size[i],"        ",j+1)
                break;
        else:
            print(i+1, "            ", program_size[i], "         Not allocated", )


blockSize = [300, 150, 500, 200]
processSize = [100, 200, 300, 100]
firstfit(blockSize,len(processSize),processSize)
