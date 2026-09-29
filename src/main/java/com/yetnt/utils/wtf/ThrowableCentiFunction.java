package com.yetnt.utils.wtf;

/**
 * A One hundred arity function which takes in, you guessed it. ONE HUNDRED parameters and returns a result.
 * Oh and it might throw.
 * <p>
 *     Added because this is a very useful functional interface that should've absolutely been apart of {@link java.util.function}
 * </p>
 * @implSpec Seriously, if you ever consider needing this, i highly recommend you take a deep breath
 * and close your laptop. Proceed to go outside and think of something better. Do Not. Reach for this.
 * @param <A> The type of the 1st parameter.
 * @param <B> The type of the 2nd parameter.
 * @param <C> The type of the 3rd parameter.
 * @param <D> The type of the 4th parameter.
 * @param <E> The type of the 5th parameter.
 * @param <F> The type of the 6th parameter.
 * @param <G> The type of the 7th parameter.
 * @param <H> The type of the 8th parameter.
 * @param <I> The type of the 9th parameter.
 * @param <J> The type of the 10th parameter.
 * @param <K> The type of the 11th parameter.
 * @param <L> The type of the 12th parameter.
 * @param <M> The type of the 13th parameter.
 * @param <N> The type of the 14th parameter.
 * @param <O> The type of the 15th parameter.
 * @param <P> The type of the 16th parameter.
 * @param <Q> The type of the 17th parameter.
 * @param <R> The type of the 18th parameter.
 * @param <S> The type of the 19th parameter.
 * @param <T> The type of the 20th parameter.
 * @param <U> The type of the 21th parameter.
 * @param <V> The type of the 22th parameter.
 * @param <W> The type of the 23th parameter.
 * @param <X> The type of the 24th parameter.
 * @param <Y> The type of the 25th parameter.
 * @param <Z> The type of the 26th parameter.
 * @param <AA> The type of the 27th parameter.
 * @param <AB> The type of the 28th parameter.
 * @param <AC> The type of the 29th parameter.
 * @param <AD> The type of the 30th parameter.
 * @param <AE> The type of the 31th parameter.
 * @param <AF> The type of the 32th parameter.
 * @param <AG> The type of the 33th parameter.
 * @param <AH> The type of the 34th parameter.
 * @param <AI> The type of the 35th parameter.
 * @param <AJ> The type of the 36th parameter.
 * @param <AK> The type of the 37th parameter.
 * @param <AL> The type of the 38th parameter.
 * @param <AM> The type of the 39th parameter.
 * @param <AN> The type of the 40th parameter.
 * @param <AO> The type of the 41th parameter.
 * @param <AP> The type of the 42th parameter.
 * @param <AQ> The type of the 43th parameter.
 * @param <AR> The type of the 44th parameter.
 * @param <AS> The type of the 45th parameter.
 * @param <AT> The type of the 46th parameter.
 * @param <AU> The type of the 47th parameter.
 * @param <AV> The type of the 48th parameter.
 * @param <AW> The type of the 49th parameter.
 * @param <AX> The type of the 50th parameter.
 * @param <AY> The type of the 51th parameter.
 * @param <AZ> The type of the 52th parameter.
 * @param <BA> The type of the 53th parameter.
 * @param <BB> The type of the 54th parameter.
 * @param <BC> The type of the 55th parameter.
 * @param <BD> The type of the 56th parameter.
 * @param <BE> The type of the 57th parameter.
 * @param <BF> The type of the 58th parameter.
 * @param <BG> The type of the 59th parameter.
 * @param <BH> The type of the 60th parameter.
 * @param <BI> The type of the 61th parameter.
 * @param <BJ> The type of the 62th parameter.
 * @param <BK> The type of the 63th parameter.
 * @param <BL> The type of the 64th parameter.
 * @param <BM> The type of the 65th parameter.
 * @param <BN> The type of the 66th parameter.
 * @param <BO> The type of the 67th parameter.
 * @param <BP> The type of the 68th parameter.
 * @param <BQ> The type of the 69th parameter.
 * @param <BR> The type of the 70th parameter.
 * @param <BS> The type of the 71th parameter.
 * @param <BT> The type of the 72th parameter.
 * @param <BU> The type of the 73th parameter.
 * @param <BV> The type of the 74th parameter.
 * @param <BW> The type of the 75th parameter.
 * @param <BX> The type of the 76th parameter.
 * @param <BY> The type of the 77th parameter.
 * @param <BZ> The type of the 78th parameter.
 * @param <CA> The type of the 79th parameter.
 * @param <CB> The type of the 80th parameter.
 * @param <CC> The type of the 81th parameter.
 * @param <CD> The type of the 82th parameter.
 * @param <CE> The type of the 83th parameter.
 * @param <CF> The type of the 84th parameter.
 * @param <CG> The type of the 85th parameter.
 * @param <CH> The type of the 86th parameter.
 * @param <CI> The type of the 87th parameter.
 * @param <CJ> The type of the 88th parameter.
 * @param <CK> The type of the 89th parameter.
 * @param <CL> The type of the 90th parameter.
 * @param <CM> The type of the 91th parameter.
 * @param <CN> The type of the 92th parameter.
 * @param <CO> The type of the 93th parameter.
 * @param <CP> The type of the 94th parameter.
 * @param <CQ> The type of the 95th parameter.
 * @param <CR> The type of the 96th parameter.
 * @param <CS> The type of the 97th parameter.
 * @param <CT> The type of the 98th parameter.
 * @param <CU> The type of the 99th parameter.
 * @param <CV> The type of the 100th parameter.
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableCentiFunction<
        A,  B,  C,  D,  E,  F,  G,  H,  I,  J,  K,  L,  M,  N,  O,  P,  Q,  R,  S,  T,  U,  V,  W,  X,  Y,  Z,
        AA, AB, AC, AD, AE, AF, AG, AH, AI, AJ, AK, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AV, AW, AX, AY, AZ,
        BA, BB, BC, BD, BE, BF, BG, BH, BI, BJ, BK, BL, BM, BN, BO, BP, BQ, BR, BS, BT, BU, BV, BW, BX, BY, BZ,
        CA, CB, CC, CD, CE, CF, CG, CH, CI, CJ, CK, CL, CM, CN, CO, CP, CQ, CR, CS, CT, CU, CV,
        CW, CX extends Throwable
        > {

    /**
     * Call the function.
     * @param a The 1st parameter which is of type {@code A}.
     * @param b The 2nd parameter which is of type {@code B}.
     * @param c The 3rd parameter which is of type {@code C}.
     * @param d The 4th parameter which is of type {@code D}.
     * @param e The 5th parameter which is of type {@code E}.
     * @param f The 6th parameter which is of type {@code F}.
     * @param g The 7th parameter which is of type {@code G}.
     * @param h The 8th parameter which is of type {@code H}.
     * @param i The 9th parameter which is of type {@code I}.
     * @param j The 10th parameter which is of type {@code J}.
     * @param k The 11th parameter which is of type {@code K}.
     * @param l The 12th parameter which is of type {@code L}.
     * @param m The 13th parameter which is of type {@code M}.
     * @param n The 14th parameter which is of type {@code N}.
     * @param o The 15th parameter which is of type {@code O}.
     * @param p The 16th parameter which is of type {@code P}.
     * @param q The 17th parameter which is of type {@code Q}.
     * @param r The 18th parameter which is of type {@code R}.
     * @param s The 19th parameter which is of type {@code S}.
     * @param t The 20th parameter which is of type {@code T}.
     * @param u The 21th parameter which is of type {@code U}.
     * @param v The 22th parameter which is of type {@code V}.
     * @param w The 23th parameter which is of type {@code W}.
     * @param x The 24th parameter which is of type {@code X}.
     * @param y The 25th parameter which is of type {@code Y}.
     * @param z The 26th parameter which is of type {@code Z}.
     * @param aa The 27th parameter which is of type {@code AA}.
     * @param ab The 28th parameter which is of type {@code AB}.
     * @param ac The 29th parameter which is of type {@code AC}.
     * @param ad The 30th parameter which is of type {@code AD}.
     * @param ae The 31th parameter which is of type {@code AE}.
     * @param af The 32th parameter which is of type {@code AF}.
     * @param ag The 33th parameter which is of type {@code AG}.
     * @param ah The 34th parameter which is of type {@code AH}.
     * @param ai The 35th parameter which is of type {@code AI}.
     * @param aj The 36th parameter which is of type {@code AJ}.
     * @param ak The 37th parameter which is of type {@code AK}.
     * @param al The 38th parameter which is of type {@code AL}.
     * @param am The 39th parameter which is of type {@code AM}.
     * @param an The 40th parameter which is of type {@code AN}.
     * @param ao The 41th parameter which is of type {@code AO}.
     * @param ap The 42th parameter which is of type {@code AP}.
     * @param aq The 43th parameter which is of type {@code AQ}.
     * @param ar The 44th parameter which is of type {@code AR}.
     * @param as The 45th parameter which is of type {@code AS}.
     * @param at The 46th parameter which is of type {@code AT}.
     * @param au The 47th parameter which is of type {@code AU}.
     * @param av The 48th parameter which is of type {@code AV}.
     * @param aw The 49th parameter which is of type {@code AW}.
     * @param ax The 50th parameter which is of type {@code AX}.
     * @param ay The 51th parameter which is of type {@code AY}.
     * @param az The 52th parameter which is of type {@code AZ}.
     * @param ba The 53th parameter which is of type {@code BA}.
     * @param bb The 54th parameter which is of type {@code BB}.
     * @param bc The 55th parameter which is of type {@code BC}.
     * @param bd The 56th parameter which is of type {@code BD}.
     * @param be The 57th parameter which is of type {@code BE}.
     * @param bf The 58th parameter which is of type {@code BF}.
     * @param bg The 59th parameter which is of type {@code BG}.
     * @param bh The 60th parameter which is of type {@code BH}.
     * @param bi The 61th parameter which is of type {@code BI}.
     * @param bj The 62th parameter which is of type {@code BJ}.
     * @param bk The 63th parameter which is of type {@code BK}.
     * @param bl The 64th parameter which is of type {@code BL}.
     * @param bm The 65th parameter which is of type {@code BM}.
     * @param bn The 66th parameter which is of type {@code BN}.
     * @param bo The 67th parameter which is of type {@code BO}.
     * @param bp The 68th parameter which is of type {@code BP}.
     * @param bq The 69th parameter which is of type {@code BQ}.
     * @param br The 70th parameter which is of type {@code BR}.
     * @param bs The 71th parameter which is of type {@code BS}.
     * @param bt The 72th parameter which is of type {@code BT}.
     * @param bu The 73th parameter which is of type {@code BU}.
     * @param bv The 74th parameter which is of type {@code BV}.
     * @param bw The 75th parameter which is of type {@code BW}.
     * @param bx The 76th parameter which is of type {@code BX}.
     * @param by The 77th parameter which is of type {@code BY}.
     * @param bz The 78th parameter which is of type {@code BZ}.
     * @param ca The 79th parameter which is of type {@code CA}.
     * @param cb The 80th parameter which is of type {@code CB}.
     * @param cc The 81th parameter which is of type {@code CC}.
     * @param cd The 82th parameter which is of type {@code CD}.
     * @param ce The 83th parameter which is of type {@code CE}.
     * @param cf The 84th parameter which is of type {@code CF}.
     * @param cg The 85th parameter which is of type {@code CG}.
     * @param ch The 86th parameter which is of type {@code CH}.
     * @param ci The 87th parameter which is of type {@code CI}.
     * @param cj The 88th parameter which is of type {@code CJ}.
     * @param ck The 89th parameter which is of type {@code CK}.
     * @param cl The 90th parameter which is of type {@code CL}.
     * @param cm The 91th parameter which is of type {@code CM}.
     * @param cn The 92th parameter which is of type {@code CN}.
     * @param co The 93th parameter which is of type {@code CO}.
     * @param cp The 94th parameter which is of type {@code CP}.
     * @param cq The 95th parameter which is of type {@code CQ}.
     * @param cr The 96th parameter which is of type {@code CR}.
     * @param cs The 97th parameter which is of type {@code CS}.
     * @param ct The 98th parameter which is of type {@code CT}.
     * @param cu The 99th parameter which is of type {@code CU}.
     * @param cv The 100th parameter which is of type {@code CV}.
     * @return Whatever the fuck this mess returns
     * @throws CX Bless your soul if this throws.
     */
    CW weep(
            A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q, R r, S s, T t, U u,
            V v, W w, X x, Y y, Z z, AA aa, AB ab, AC ac, AD ad, AE ae, AF af, AG ag, AH ah, AI ai, AJ aj, AK ak, AL al,
            AM am, AN an, AO ao, AP ap, AQ aq, AR ar, AS as, AT at, AU au, AV av, AW aw, AX ax, AY ay, AZ az, BA ba,
            BB bb, BC bc, BD bd, BE be, BF bf, BG bg, BH bh, BI bi, BJ bj, BK bk, BL bl, BM bm, BN bn, BO bo, BP bp,
            BQ bq, BR br, BS bs, BT bt, BU bu, BV bv, BW bw, BX bx, BY by, BZ bz, CA ca, CB cb, CC cc, CD cd, CE ce,
            CF cf, CG cg, CH ch, CI ci, CJ cj, CK ck, CL cl, CM cm, CN cn, CO co, CP cp, CQ cq, CR cr, CS cs, CT ct,
            CU cu, CV cv
    ) throws CX;
}
