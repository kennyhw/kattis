x = input()
x = x.split()

r = int(x[0])
c = int(x[1])
zr = int(x[2])
zc = int(x[3])

res = [['empty' for j in range(0, c * zc)] for i in range(0, r * zr)]

for i in range(0, r):
    entryc = input()

    for j in range(0, c):
        entry = entryc[j]
        
        rstart = i * zr
        cstart = j * zc

        for a in range(0, zr):
            for b in range(0, zc):
                res[rstart + a][cstart + b] = entry

for i in range(0, r * zr):
    for j in range(0, c * zc):
        print(res[i][j], end='')
    
    print()
