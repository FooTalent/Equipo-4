import * as React from 'react';
import { Slot } from '@radix-ui/react-slot';
import { cva } from 'class-variance-authority';

import { cn } from '@/lib/utils';

const buttonVariants = cva(
  'inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50',
  {
    variants: {
      variant: {
        default: 'bg-primary text-primary-foreground hover:bg-primary/90',
        green: 'text-white focus:text-black bg-green disabled:bg-greenDisabled disabled:text-black disabled:text-opacity-50 focus:bg-white hover:bg-greenHover focus:text-green focus:border focus:border-green',
        red: 'text-white focus:text-black bg-red disabled:bg-redDisabled disabled:text-black disabled:text-opacity-50 focus:bg-white hover:bg-redHover focus:text-red focus:border focus:border-red',
        orange: 'text-black focus:text-black bg-orange disabled:bg-orangeDisabled disabled:text-black disabled:text-opacity-50 focus:bg-white hover:bg-orangeHover focus:text-orange focus:border focus:border-orange',
        destructive:
          'bg-destructive text-destructive-foreground hover:bg-destructive/90',
        outline:
          'border border-input bg-background hover:bg-accent hover:text-accent-foreground',
        secondary:
          'bg-secondary text-secondary-foreground hover:bg-secondary/80',
        ghost: 'hover:bg-accent hover:text-accent-foreground',
        link: 'text-primary underline-offset-4 hover:underline',
      },
      size: {
        default: 'h-10 px-4 py-2',
        sm: 'h-9 rounded-md px-3',
        lg: 'h-11 rounded-md px-8',
        icon: 'h-10 w-10',
      },
    },
    defaultVariants: {
      variant: 'default',
      size: 'default',
    },
  }
);

const Button = React.forwardRef(({ className, variant, size, asChild = false, ...props }, ref) => {
  const Comp = asChild ? Slot : 'button';
  return (
    (<Comp
      className={cn(buttonVariants({ variant, size, className }))}
      ref={ref}
      {...props} />)
  );
});
Button.displayName = 'Button';

export { Button, buttonVariants };
