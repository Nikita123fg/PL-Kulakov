import math
x=float(182.5)
y=float(18.225)
z=float(0.03298)

s=abs(x**(y/x)-(y/x)**(1/3))+(y-x)*(math.cos(y)-((z)/(y-x)))/(1+(y-x)**2)
print(s)
