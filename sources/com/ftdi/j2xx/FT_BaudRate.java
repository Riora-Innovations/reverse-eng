package com.ftdi.j2xx;

final class FT_BaudRate {
    private static final int FT_CLOCK_RATE = 3000000;
    private static final int FT_CLOCK_RATE_HI = 12000000;
    private static final int FT_SUB_INT_0_0 = 0;
    private static final int FT_SUB_INT_0_125 = 49152;
    private static final int FT_SUB_INT_0_25 = 32768;
    private static final int FT_SUB_INT_0_375 = 0;
    private static final int FT_SUB_INT_0_5 = 16384;
    private static final int FT_SUB_INT_0_625 = 16384;
    private static final int FT_SUB_INT_0_75 = 32768;
    private static final int FT_SUB_INT_0_875 = 49152;
    private static final int FT_SUB_INT_MASK = 49152;

    private FT_BaudRate() {
    }

    static byte FT_GetDivisor(int rate, int[] divisors, boolean bm) {
        int temp_accuracy;
        int temp_mod;
        byte rval;
        byte rval2 = FT_CalcDivisor(rate, divisors, bm);
        if (rval2 == -1) {
            return -1;
        }
        if (rval2 == 0) {
            divisors[0] = (divisors[0] & -49153) + 1;
        }
        int temp_actual = FT_CalcBaudRate(divisors[0], divisors[1], bm);
        if (rate > temp_actual) {
            temp_accuracy = ((rate * 100) / temp_actual) - 100;
            temp_mod = ((rate % temp_actual) * 100) % temp_actual;
        } else {
            temp_accuracy = ((temp_actual * 100) / rate) - 100;
            temp_mod = ((temp_actual % rate) * 100) % rate;
        }
        if (temp_accuracy < 3) {
            rval = 1;
        } else if (temp_accuracy == 3 && temp_mod == 0) {
            rval = 1;
        } else {
            rval = 0;
        }
        return rval;
    }

    private static byte FT_CalcDivisor(int rate, int[] divisors, boolean bm) {
        int modifier;
        byte ok = 1;
        if (rate == 0 || ((FT_CLOCK_RATE / rate) & -16384) > 0) {
            return -1;
        }
        divisors[0] = FT_CLOCK_RATE / rate;
        divisors[1] = 0;
        if (divisors[0] == 1 && ((FT_CLOCK_RATE % rate) * 100) / rate <= 3) {
            divisors[0] = 0;
        }
        if (divisors[0] == 0) {
            return 1;
        }
        int t = ((FT_CLOCK_RATE % rate) * 100) / rate;
        if (!bm) {
            if (t <= 6) {
                modifier = 0;
            } else if (t <= 18) {
                modifier = 49152;
            } else if (t <= 37) {
                modifier = 32768;
            } else if (t <= 75) {
                modifier = 16384;
            } else {
                modifier = 0;
                ok = 0;
            }
        } else if (t <= 6) {
            modifier = 0;
        } else if (t <= 18) {
            modifier = 49152;
        } else if (t <= 31) {
            modifier = 32768;
        } else if (t <= 43) {
            modifier = 0;
            divisors[1] = 1;
        } else if (t <= 56) {
            modifier = 16384;
        } else if (t <= 68) {
            modifier = 16384;
            divisors[1] = 1;
        } else if (t <= 81) {
            modifier = 32768;
            divisors[1] = 1;
        } else if (t <= 93) {
            modifier = 49152;
            divisors[1] = 1;
        } else {
            modifier = 0;
            ok = 0;
        }
        divisors[0] = divisors[0] | modifier;
        return ok;
    }

    private static final int FT_CalcBaudRate(int divisor, int extdiv, boolean bm) {
        if (divisor == 0) {
            return FT_CLOCK_RATE;
        }
        int rate = (-49153 & divisor) * 100;
        if (bm) {
            if (extdiv != 0) {
                switch (divisor & 49152) {
                    case 0:
                        rate += 37;
                        break;
                    case 16384:
                        rate += 62;
                        break;
                    case 32768:
                        rate += 75;
                        break;
                    case 49152:
                        rate += 87;
                        break;
                }
            } else {
                switch (divisor & 49152) {
                    case 16384:
                        rate += 50;
                        break;
                    case 32768:
                        rate += 25;
                        break;
                    case 49152:
                        rate += 12;
                        break;
                }
            }
        } else {
            switch (divisor & 49152) {
                case 16384:
                    rate += 50;
                    break;
                case 32768:
                    rate += 25;
                    break;
                case 49152:
                    rate += 12;
                    break;
            }
        }
        return 300000000 / rate;
    }

    static final byte FT_GetDivisorHi(int rate, int[] divisors) {
        int temp_accuracy;
        int temp_mod;
        byte rval;
        byte rval2 = FT_CalcDivisorHi(rate, divisors);
        if (rval2 == -1) {
            return -1;
        }
        if (rval2 == 0) {
            divisors[0] = (divisors[0] & -49153) + 1;
        }
        int temp_actual = FT_CalcBaudRateHi(divisors[0], divisors[1]);
        if (rate > temp_actual) {
            temp_accuracy = ((rate * 100) / temp_actual) - 100;
            temp_mod = ((rate % temp_actual) * 100) % temp_actual;
        } else {
            temp_accuracy = ((temp_actual * 100) / rate) - 100;
            temp_mod = ((temp_actual % rate) * 100) % rate;
        }
        if (temp_accuracy < 3) {
            rval = 1;
        } else if (temp_accuracy == 3 && temp_mod == 0) {
            rval = 1;
        } else {
            rval = 0;
        }
        return rval;
    }

    private static byte FT_CalcDivisorHi(int rate, int[] divisors) {
        int modifier;
        byte ok = 1;
        if (rate == 0 || ((FT_CLOCK_RATE_HI / rate) & -16384) > 0) {
            return -1;
        }
        divisors[1] = 2;
        if (rate >= 11640000 && rate <= 12360000) {
            divisors[0] = 0;
            return 1;
        } else if (rate < 7760000 || rate > 8240000) {
            divisors[0] = FT_CLOCK_RATE_HI / rate;
            divisors[1] = 2;
            if (divisors[0] == 1 && ((FT_CLOCK_RATE_HI % rate) * 100) / rate <= 3) {
                divisors[0] = 0;
            }
            if (divisors[0] == 0) {
                return 1;
            }
            int t = ((FT_CLOCK_RATE_HI % rate) * 100) / rate;
            if (t <= 6) {
                modifier = 0;
            } else if (t <= 18) {
                modifier = 49152;
            } else if (t <= 31) {
                modifier = 32768;
            } else if (t <= 43) {
                modifier = 0;
                divisors[1] = divisors[1] | 1;
            } else if (t <= 56) {
                modifier = 16384;
            } else if (t <= 68) {
                modifier = 16384;
                divisors[1] = divisors[1] | 1;
            } else if (t <= 81) {
                modifier = 32768;
                divisors[1] = divisors[1] | 1;
            } else if (t <= 93) {
                modifier = 49152;
                divisors[1] = divisors[1] | 1;
            } else {
                modifier = 0;
                ok = 0;
            }
            divisors[0] = divisors[0] | modifier;
            return ok;
        } else {
            divisors[0] = 1;
            return 1;
        }
    }

    private static int FT_CalcBaudRateHi(int divisor, int extdiv) {
        if (divisor == 0) {
            return FT_CLOCK_RATE_HI;
        }
        if (divisor == 1) {
            return 8000000;
        }
        int rate = (-49153 & divisor) * 100;
        if ((extdiv & 65533) != 0) {
            switch (divisor & 49152) {
                case 0:
                    rate += 37;
                    break;
                case 16384:
                    rate += 62;
                    break;
                case 32768:
                    rate += 75;
                    break;
                case 49152:
                    rate += 87;
                    break;
            }
        } else {
            switch (divisor & 49152) {
                case 16384:
                    rate += 50;
                    break;
                case 32768:
                    rate += 25;
                    break;
                case 49152:
                    rate += 12;
                    break;
            }
        }
        return 1200000000 / rate;
    }
}
