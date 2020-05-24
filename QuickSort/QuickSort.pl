#!ust/bin/perl
# $#input_Array use to get the size of the array, i.e (size-1)
#operation done like,
#1) smallNumber-> 4,3 pivot-> 5 bigNumber-> 9,8 
#2) pivot -> 3, bigNumber -> 4
#3) return 3,4
#4) pivot -> 5
#5) pivot -> 8, bigNumber -> 9
#6) return 8,9
#7) return (3,4),5,(8,9);
#8) output_Array -> 3,4,5,8,9
sub quickSort{
    my @input_Array = @_;
    if($#input_Array < 1){
        return @input_Array;
    }
    my $pivot = pop(@input_Array);
    my @smallNumber;
    my @bigNumber;
    foreach my $array_val(@input_Array){
        if($array_val < $pivot){
            push(@smallNumber,$array_val);
        }else{
            push(@bigNumber,$array_val);
        }
    }
    return quickSort(@smallNumber),$pivot,quickSort(@bigNumber);
}
@input_Array = quickSort(4,9,3,8,5);
foreach my $var(@input_Array){
    print "$var ";
}