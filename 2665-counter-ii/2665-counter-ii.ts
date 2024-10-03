type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    
    let real = init
    
    return {
        
        increment: () => {
            return ++real;
        },
        decrement: () => {
            return --real;
        },
        reset: () => {
            return real = init;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */