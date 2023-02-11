class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int rqi = 0, rqj = 0, bqi = 0, bqj = 0, nrq = 0, nbq = 0, rql = 10, bql = 10;
        int pathLen = 0;
        int nvis = 0;
        int[] redRes = new int[n], blueRes = new int[n];
        int[] redQueue = new int[rql], blueQueue = new int[bql];
        int[][] redVerts = new int[n][redEdges.length/n + 2];
        int[][] blueVerts = new int[n][blueEdges.length/n + 2];
        for (int i = 0; i < n; i++) {
            redRes[i] = 0x7fffffff;
            blueRes[i] = 0x7fffffff;
        }
        fillVerts(redVerts, redEdges);
        fillVerts(blueVerts, blueEdges);
        rqj = (rqj + 1) % rql; nrq++;
        bqj = (bqj + 1) % bql; nbq++;
        
        
        while(nrq > 0 || nbq > 0) {
            int[] varr;
            int vl, nrEls = nrq, nbEls = nbq;
            pathLen++;
            for(int i = 0; i < nrEls; i++) {
                varr = redVerts[redQueue[rqi]];
                rqi = (rqi + 1) % rql;
                nrq--;
                vl = varr[0];
                for (int j = 1; j <= vl; j++) {
                    if (pathLen < redRes[varr[j]]) {
                        if (nbq == bql) {
                            blueQueue = dblSize(blueQueue, bqi);
                            bqi = 0;
                            bqj = bql;
                            bql = 2 * bql;
                        }
                        redRes[varr[j]] = pathLen;  
                        blueQueue[bqj] = varr[j];
                        bqj = (bqj + 1) % bql;
                        nbq++;
                    }
                } 
            }
            
            for(int i = 0; i < nbEls; i++) {
                varr = blueVerts[blueQueue[bqi]];
                bqi = (bqi + 1) % bql;
                nbq--;
                vl = varr[0];
                for (int j = 1; j <= vl; j++) {
                    if (pathLen < blueRes[varr[j]]) {
                        //System.out.println("nrq= " + nrq + " rql= " + rql);
                        if (nrq == rql) {
                            redQueue = dblSize(redQueue, rqi);
                            rqi = 0;
                            rqj = rql;
                            rql = 2 * rql;
                        }
                        blueRes[varr[j]] = pathLen;
                        redQueue[rqj] = varr[j];
                        rqj = (rqj + 1) % rql;
                        nrq++;
                    }
                } 
            }
        }
        int tmp;
        redRes[0] = 0;
        for (int i = 0; i < n; i++) {
            tmp = redRes[i] <= blueRes[i] ? redRes[i] : blueRes[i];
            redRes[i] = tmp == 0x7fffffff ? -1 : tmp;
        }
        //System.out.println(Arrays.toString(res));
        
        return redRes;
    }
    
    void fillVerts(int[][] verts, int[][] edges) {
        int v1, v2, el = edges.length;
        int[] varr;
        for (int i = 0; i < el; i++) {
            v1 = edges[i][0];
            v2 = edges[i][1];
            varr = verts[v1];
            verts[v1] = varr.length == ++varr[0] ? dblSize(varr, 0) : varr;
            verts[v1][varr[0]] = v2;
        }
    }
    
    int[] dblSize(int[] arr, int s) {
        int l = arr.length;
        int[] narr = new int[2 * l];
        for (int i = 0; i < l; i++, s++) narr[i] = arr[s % l];
        return narr;
    }
}