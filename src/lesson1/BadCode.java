package lesson1;

public class BadCode<a,b,c,d,e,f,g,h,i,j,k,o,p,q,r
        ,s,t,u,v,w,x,y,z> {
    public BadCode(a a1, b b1, c c1,
                   d d1, e e1, f f1,
                   g g1, h h1, i i1,
                   j j1, k k1, o o1,
                   p p1, q q1, r r1,
                   s s1, t t1, u u1,
                   v v1, w w1, x x1,
                   y y1, z z1) {
        System.out.println("NO NO NO NO NO NO!!!");

    }

    public static void main(String[] args) {
        new BadCode<>(1, 2, 'a', "dasd",
                1,2,123,4,13,5,13,6
        , "saf", 1, true, false, false, 1, 1,
                123, 213, 12, 1);
    }
}
