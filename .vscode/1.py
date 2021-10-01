h=set()
for i in range(len(h)):
    z=l.copy()
    while z[i]<0:
        z[i]*=-1
    h.add(sum(z))
    return max(h)